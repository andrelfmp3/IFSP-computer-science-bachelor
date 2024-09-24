package main

import (
	"fmt"
	"math/rand"
	"os"
	"sync"
	"time"
)

func main() {
	file, err := os.Create("secaocritica.txt") // cria arquivo
	if err != nil {                            // verifica se houve erro
		fmt.Println("Erro ao criar o arquivo. Motivo: ", err)
		return
	}
	defer file.Close() // fecha arquivo

	var wg sync.WaitGroup // sincroniza

	// acesso exclusivo via token
	token := make(chan struct{}, 1)
	token <- struct{}{}

	var totalLinhasEscritas int // contador

	for i := 0; i < 3; i++ {
		wg.Add(1)
		go thread(file, rune('X'+i), &wg, token, &totalLinhasEscritas) // cria thread (dentro do for, 3 gorrotinas)
	}

	wg.Wait() // aguarda todas as thread terminarem

	fmt.Println("Fim do programa.")
}

func thread(file *os.File, char rune, wg *sync.WaitGroup, token chan struct{}, totalLinhasEscritas *int) {
	defer wg.Done() // marca como concluída quando retornar

	numeroAleatorio := rand.Intn(6) + 5 // tempo de espera aleatório entre 5 e 10 segundos
	fmt.Printf("Thread %c iniciando com espera de %d segundos.\n", char, numeroAleatorio)

	time.Sleep(time.Duration(numeroAleatorio) * time.Second) // aguarda o tempo aleatório

	for i := 0; i < 10; i++ {
		// acesso exclusivo via token
		select {
		case <-token: // adquire o token para acessar o arquivo
			fmt.Printf("Thread %c abriu o arquivo.\n", char)

			// atualiza e verifica totalLinhasEscritas sob proteção do token
			linha := fmt.Sprintf("Thread %c: %s linha escrita\n", char, numeroParaPalavra(i%3+1))
			_, err := file.WriteString(linha)
			if err != nil { // trata erros na escrita
				fmt.Println("Erro ao escrever no arquivo. Motivo: ", err)
				token <- struct{}{} // libera o token se houver erro
				return
			}

			// atualiza o contador de linhas
			*totalLinhasEscritas++
			if *totalLinhasEscritas >= 30 {
				token <- struct{}{} // libera o token se o limite for alcançado
				return
			}

			fmt.Printf("Thread %c escreveu em arquivo.\n", char)

			time.Sleep(1 * time.Second) // aguarda 1s entre as escritas

			// libera token
			token <- struct{}{}
			fmt.Printf("Thread %c fechou o arquivo.\n", char)
		default:
			// sem token
			fmt.Printf("Thread %c tentou acessar o arquivo sem sucesso.\n", char)
			time.Sleep(10 * time.Second)
			i--
		}
	}
}

// números para palavras (formatação do exercício)
func numeroParaPalavra(numero int) string {
	switch numero {
	case 1:
		return "primeira"
	case 2:
		return "segunda"
	case 3:
		return "terceira"
	default:
		return fmt.Sprintf("%dª", numero)
	}
}
