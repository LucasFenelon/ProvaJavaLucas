DeadLock é um encadeamento fechado de thread resultado em um status de blocked, consequentemente interrompendo a operação do sistema, o raciocínio é o seguinte:
	Em um caso prático de carrinho de compras de um E-commerce, imagina-se um cenário em que hajam mais de uma transação ao mesmo tempo, por exemplo, a compra de um mesmo produto que é o último do estoque por dois usuários diferentes, na prática uma requisição sempre vai chegar primeiro do que outra, porem dependendo do tempo de resposta ocasionalmente do sistema, podemos cair em um caso de encadeamento de dependência cíclica de threads. Um passo à passo para solução desse problema seria:
- Análise e monitoria de threads em “Waiting” para localiza o pregão.
- Análise funcional do código para identificar o exato trecho que gera o problema.
- Dependendo do caso, implementar o uso de “syncronized” para tratamento correto pela VM.
- Dependendo do caso correção do código para obedecer uma ordem de prioridades, sempre levando em consideração o registro mais velho, invalidando novas solicitações até a finalização do primeiro processamento, garantindo o trabalho sincronizado das requisições.
