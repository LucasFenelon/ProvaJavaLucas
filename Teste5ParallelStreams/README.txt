ParallelStreams nos permitem trabalhar um conjunto de dados de forma paralela, o raciocínio é o seguinte:
	Assim como em um sistema elétrico onde nós temos esquemas que podem direcionar o trafego da corrente elétrica de forma serial e sequencial, também podemos direcionar isso de forma paralela, ou seja, fazer com que o esforço seja compartilhado e consequentemente o esforço reduzido. Convergindo isso para nossa realidade, significa dizer para o Java que todo o processamento que deve ser feito e que esteja contido dentro de um ParallelStream, deve ser tratado de forma distribuída, na prática o compilador abrirá mais de uma Thread, porém não de forma aleatória, existem no Java 8 regras implícita que se responsabilizando por fazer automaticamente um estudo da quantidade de Threads devem ser abertas levando em consideração dentre vários parâmetros, a capacidade da máquina e o tamanho do conjunto, para que seja distribuído na maior quantidade possível afim de se obter um resultado factível e de alta performance.
	De contraponto o tempo de I/O para agrupar todo o conjunto no retorno das informações distribuídas também se torna uma operação custosa, ainda assim dependendo do tráfego de informações a ser processado o ganho é maior do que o processamento serial. Contudo isso invalida o PrallelStream de ser a melhor solução para um conjunto pequeno de dados, contando esse alto custo I/O para uma proporção reduzida de dados.
Análise comparativa:
Stream
- Thread única dedicada de processamento;
- Recurso sobrecarregado;
- Tempo reduzido de I/O no retorno das informações;
- Recursos básicos do Java 8;
- Bom para conjunto reduzido de dados;
ParallelStream
- Threads selecionadas para processamento distribuído;
- Recursos espalhados com menos esforço;
- Tempo alto de I/O no retorno das informações;
- Recursos avançados do Java 8 para melhor distribuição possível (Analise de máquina, MapResuce , etc...);
- Bom para grande conjunto dados;
