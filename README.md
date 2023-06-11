# ancient-game-scoreboard

### Introdução
O presente algoritmo analisa N pares de números (A,B) e os respectivos arrays formados pela combinação linear de As e Bs.
Seu objetivo é descobrir se é possível através da permutação de As e Bs, e/ou da remoção de 1 dos pares, chegar a dois arrays com somas iguais.
#### Situação hipotética
Supõe-se que se tem em mãos um conjunto de N placas. Cada placa possui dois números (um superior e um inferior).
Ao posicionar todas as placas lado a lado forma-se uma sequência de números superiores e uma sequência de números inferiores.
Busca-se descobrir se através da rotação das placas é possível fazer com que a soma destas duas sequências seja igual.
Além disso, caso a conclusão seja negativa, torna-se possível remover uma das placas, com o imperativo de que seja removida a placa que produza a maior soma possível.

### Funcionamento
Baseado na estrutura de dados árvore binária, o programa itera por cada placa e cria uma branch para cada soma possível: placa normal, placa invertida. 
Assim, cada placa se traduz como um nível da árvore, e os nós daquele nível se traduzem como todas as combinações possíveis de somas da primeira placa até aquele ponto.
O programa vai criando branches e armazenando os resultados em um array (sempre sobreescrevendo o array do nível anterior pelo do nível atual).
Ao fim, ao computar a última placa, este possuirá um array com todas as folhas, ou seja, todas as 2^n somas possíveis.
<br>
Aplicou-se sobre esse funcionamento um método de otimização de branch and bound, ou seja, de eliminação de caminhos não relevantes da árvore a cada nível.
Para tal, ao invés de se utilizar um array normal utilizou-se a estrutura de dados conjunto(set) de forma que, a cada nível, não sejam adicionados nós com somas iguais.
<br>
Ainda, caso não seja encontrada uma combinação que sacie as exigências, este verifica a possibilidade de eliminar uma das placas.

### Como utilizar
1. Buildar todos os arquivos .java da pasta src/. Uma forma de fazê-lo no terminal é através do comando ```find . -name "*.java" -print | xargs javac```

2. Para rodar basta executar o arquivo AgsMain passando os parâmetros necessários.

#### Parâmetros
O programa recebe dois parâmetros, sendo o primeiro obrigatório e o segundo opcional.<br>
##### Primeiro parâmetro: 
path para o arquivo de input.
##### Segundo parâmetro (opcional):
Este parâmetro possibilita a visualizar/exportar logs e estatísticas a respeito da execução. Omiti-lo fará o programa imprimir apenas o resultado final. Segue abaixo as opções: <br>
```logs``` - Exibe no terminal informações relevantes sobre as etapas da execução do programa.<br>
```stats``` - Exibe no formato CSV estatísticas a respeito do método de otimização Branch and Bound utilizado e sua eficácia. O CSV correlaciona N, total de combinações, combinações realmente consideradas, combinações desconsideradas e branches da árvore eliminadas a cada etapa. De forma a produzir um CSV limpo, este parâmetro bloqueia a exibição do resultado final, servindo apenas para a produção de estatísticas.<br>
```time``` - Correlaciona no formato CSV o tamanho da entrada (N) com o tempo total de execução até se chegar a uma resposta. Sua utilização bloqueia a exibição do resultado final.<br>
```all``` - Exibe todos os logs, stats, time e resultado final.

###### Sugestão para exportar os arquivos CSV
Sugere-se utilizar o operador ```>``` na hora de executar o programa, passando na sequência o path para a geração do arquivo. Segue o exemplo:<br>
```java AgsMain testCases/in3 stats > generatedFiles/myStats.csv```
