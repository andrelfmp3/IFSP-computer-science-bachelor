def f(x):
    return x**2 - 4  # Exemplo: função f(x) = x^2 - 4, cujas raízes são 2 e -2

# Método Secante
def metodo_secante(a, b, N):
    if f(a) * f(b) >= 0:
        print("O Método Secante falha.")
        return None
    1
    a_n = a
    b_n = b
    
    for n in range(1, N + 1):
        # Calculando o novo valor m_n
        m_n = a_n - f(a_n) * (b_n - a_n) / (f(b_n) - f(a_n))
        f_m_n = f(m_n)
        
        print(f"Iteração {n}: m_n = {m_n}, f(m_n) = {f_m_n}")
        
        # Cálculo do erro relativo
        if m_n != 0:
            erro_relativo = abs((m_n - a_n) / m_n)
            # print(f"Erro relativo: {erro_relativo}")
        
        # Atualizando os valores de a_n e b_n com base em f(a_n) e f(m_n)
        if f(a_n) * f_m_n < 0:
            b_n = m_n
        elif f(b_n) * f_m_n < 0:
            a_n = m_n
        elif f_m_n == 0:
            print("Solução exata encontrada.")
            return m_n
        
    print(f"Erro relativo: {erro_relativo}")
    # Retorna a raiz aproximada
    return a_n - f(a_n) * (b_n - a_n) / (f(b_n) - f(a_n))

# Entrada de dados
print('Método Secante')

a = float(input('Entre com um valor 1: '))
b = float(input('Entre com um valor 2: '))
N = int(input('Número máximo de iterações: '))

# Chama a função Método Secante
raiz = metodo_secante(a, b, N)

if raiz is not None:
    print(f"A raiz aproximada encontrada é: {raiz}")
else:
    print("O Método Secante falhou.")
