ParallelStreams nos permitem trabalhar um conjunto de dados de forma paralela, o racioc�nio � o seguinte:
	Assim como em um sistema el�trico onde n�s temos esquemas que podem direcionar o trafego da corrente el�trica de forma serial e sequencial, tamb�m podemos direcionar isso de forma paralela, ou seja, fazer com que o esfor�o seja compartilhado e consequentemente o esfor�o reduzido. Convergindo isso para nossa realidade, significa dizer para o Java que todo o processamento que deve ser feito e que esteja contido dentro de um ParallelStream, deve ser tratado de forma distribu�da, na pr�tica o compilador abrir� mais de uma Thread, por�m n�o de forma aleat�ria, existem no Java 8 regras impl�cita que se responsabilizando por fazer automaticamente um estudo da quantidade de Threads devem ser abertas levando em considera��o dentre v�rios par�metros, a capacidade da m�quina e o tamanho do conjunto, para que seja distribu�do na maior quantidade poss�vel afim de se obter um resultado fact�vel e de alta performance.
	De contraponto o tempo de I/O para agrupar todo o conjunto no retorno das informa��es distribu�das tamb�m se torna uma opera��o custosa, ainda assim dependendo do tr�fego de informa��es a ser processado o ganho � maior do que o processamento serial. Contudo isso invalida o PrallelStream de ser a melhor solu��o para um conjunto pequeno de dados, contando esse alto custo I/O para uma propor��o reduzida de dados.
An�lise comparativa:
Stream
- Thread �nica dedicada de processamento;
- Recurso sobrecarregado;
- Tempo reduzido de I/O no retorno das informa��es;
- Recursos b�sicos do Java 8;
- Bom para conjunto reduzido de dados;
ParallelStream
- Threads selecionadas para processamento distribu�do;
- Recursos espalhados com menos esfor�o;
- Tempo alto de I/O no retorno das informa��es;
- Recursos avan�ados do Java 8 para melhor distribui��o poss�vel (Analise de m�quina, MapResuce , etc...);
- Bom para grande conjunto dados;
