DeadLock � um encadeamento fechado de thread resultado em um status de blocked, consequentemente interrompendo a opera��o do sistema, o racioc�nio � o seguinte:
	Em um caso pr�tico de carrinho de compras de um E-commerce, imagina-se um cen�rio em que hajam mais de uma transa��o ao mesmo tempo, por exemplo, a compra de um mesmo produto que � o �ltimo do estoque por dois usu�rios diferentes, na pr�tica uma requisi��o sempre vai chegar primeiro do que outra, porem dependendo do tempo de resposta ocasionalmente do sistema, podemos cair em um caso de encadeamento de depend�ncia c�clica de threads. Um passo � passo para solu��o desse problema seria:
- An�lise e monitoria de threads em �Waiting� para localiza o preg�o.
- An�lise funcional do c�digo para identificar o exato trecho que gera o problema.
- Dependendo do caso, implementar o uso de �syncronized� para tratamento correto pela VM.
- Dependendo do caso corre��o do c�digo para obedecer uma ordem de prioridades, sempre levando em considera��o o registro mais velho, invalidando novas solicita��es at� a finaliza��o do primeiro processamento, garantindo o trabalho sincronizado das requisi��es.
