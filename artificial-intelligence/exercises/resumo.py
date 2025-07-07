import pandas as pd  

df_exemplo = pd.read_csv('teste.csv', sep=",") 
df_outro_exemplo = pd.read_csv('teste.csv') # encoding="latin-1")  

df_exemplo = df_exemplo[df_exemplo['AAA'] == 'BBB']  # Filtra linhas onde a coluna 'AAA' tem valor igual a 'BBB'
df_exemplo = df_exemplo[['ColunaUm', 'ColunaDois']]  # Mantém apenas as colunas selecionadas

df_exemplo.sort_values("coluna", ascending=False, inplace=True)  # Ordena o DataFrame pela coluna escolhida, em ordem decrescente

df = df_exemplo.set_index("colunaEquivalenteExemplo").join(df_outro_exemplo.set_index('ColunaEquivalenteOutroExemplo'), how='inner')

df[['coluna']].plot()  # Gera um gráfico de linha da coluna especificada
df.plot(kind="scatter", x='colunaX', y='colunaY')  # Gera gráfico de dispersão entre colunaX e colunaY

x = df.drop("label", axis=1)  # Remove a coluna 'label' e mantém o resto como X (entradas)
y = df['label']               # Define a coluna 'label' como y (saída)

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(x, y, test_size=0.20, random_state=42)  # Divide 80/20

from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()                         # Cria objeto que padroniza os dados
X_train_scaled = scaler.fit_transform(X_train)    # Aplica padrão nos dados de treino (média=0, desvio=1)

from sklearn.tree import DecisionTreeClassifier
clf = DecisionTreeClassifier().fit(X_train_scaled, y_train)  # Treina o classificador com os dados normalizados

from sklearn.linear_model import LinearRegression
lr = LinearRegression()
lr.fit(x_train, y_train)   # Ajusta o modelo aos dados de treino

lr.coef_        # Coeficientes (inclinação) para cada variável
lr.intercept_   # Intercepto (valor de y quando X=0)
lr.score(x_test, y_test)  # Retorna o R² — quanto da variação é explicada pelo modelo

y_pred = lr.predict(x_test)  # Faz predições com o modelo
from sklearn.metrics import root_mean_squared_error
root_mean_squared_error(y_test, y_pred)  # Calcula o erro médio da previsão

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
X_train_norm = scaler.fit_transform(X_train)  # Normaliza os dados de treino

from sklearn.neural_network import MLPClassifier
clf = MLPClassifier(hidden_layer_sizes=(10, 100, 10), max_iter=1000)  # 3 camadas ocultas: 10-100-10 neurônios
clf = clf.fit(X_train_norm, y_train)  # Treinamento com os dados normalizados

from sklearn.metrics import accuracy_score
predicted = clf.predict(scaler.transform(X_test))       # Faz previsões com os dados de teste normalizados
accuracy = accuracy_score(y_test, predicted)            # Calcula a acurácia da rede
print("MLP: ", accuracy)                                # Exibe a acurácia