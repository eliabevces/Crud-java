# Crud-java

Api de cadastramento e edição de pessoas

## Estrutura
- [models](https://github.com/eliabevces/Crud-java/tree/master/src/main/java/com/example/crud_pessoa/models "models")
	- [Pessoa](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/models/Pessoa.java "Pessoa")
	- [Endereço](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/models/Endereco.java "Endereço")


- [Controllers](https://github.com/eliabevces/Crud-java/tree/master/src/main/java/com/example/crud_pessoa/controllers "controllers")
	- [Pessoa Controller](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/controllers/PessoaController.java "PessoaController.java")

- [Services](https://github.com/eliabevces/Crud-java/tree/master/src/main/java/com/example/crud_pessoa/services "Services")
	- [Pessoa Service](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/services/PessoaService.java "Pessoa Service")
	- [Pessoa Service implementation](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/services/PessoaServiceImpl.java "Pessoa Service implementation")

- [Repositories](https://github.com/eliabevces/Crud-java/tree/master/src/main/java/com/example/crud_pessoa/repositories "repo")
	- [Pessoa Repository](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/repositories/PessoaRepository.java "Pessoa Repository")
	- [Endereço Repository](https://github.com/eliabevces/Crud-java/blob/master/src/main/java/com/example/crud_pessoa/repositories/EnderecoRepository.java "Endereço Transaction Repository")



## Endpoints

### GET Pessoas
- http://localhost:8080/pessoas
- Objetivo: Listar pessoas
- input: Nada

- Retorno do exemplo :
		
``` json
[
	{
		"id": 1,
		"nome": "Fulano",
		"data_nascimento": "2000-08-21",
		"enderecos": [
			{
				"id": 1,
				"cep": "38425684",
				"numero": 47,
				"cidade": "São Paulo",
				"principal": true,
				"logradouro": "Rua 1"
			},
			{
				"id": 2,
				"cep": "38478684",
				"numero": 9,
				"cidade": "Rio de Janeiro",
				"principal": false,
				"logradouro": "Rua 2"
			}
		],
		"principalEndereco": {
			"id": 1,
			"cep": "38425684",
			"numero": 47,
			"cidade": "São Paulo",
			"principal": true,
			"logradouro": "Rua 1"
		}
	},
	{
		"id": 2,
		"nome": "Siclano",
		"data_nascimento": "1982-02-10",
		"enderecos": [
			{
				"id": 3,
				"cep": "38865184",
				"numero": 26,
				"cidade": "São Paulo",
				"principal": true,
				"logradouro": "Rua 3"
			},
			{
				"id": 4,
				"cep": "38414862",
				"numero": 8712,
				"cidade": "Uberlandia",
				"principal": false,
				"logradouro": "Rua 4"
			}
		],
		"principalEndereco": {
			"id": 3,
			"cep": "38865184",
			"numero": 26,
			"cidade": "São Paulo",
			"principal": true,
			"logradouro": "Rua 3"
		}
	},
	{
		"id": 3,
		"nome": "Beltrano",
		"data_nascimento": "2003-03-01",
		"enderecos": [
			{
				"id": 5,
				"cep": "12486324",
				"numero": 487,
				"cidade": "Brasilia",
				"principal": true,
				"logradouro": "Rua 5"
			},
			{
				"id": 6,
				"cep": "86219872",
				"numero": 2,
				"cidade": "Anapolis",
				"principal": false,
				"logradouro": "Rua 6"
			}
		],
		"principalEndereco": {
			"id": 5,
			"cep": "12486324",
			"numero": 487,
			"cidade": "Brasilia",
			"principal": true,
			"logradouro": "Rua 5"
		}
	}
]
```
### Post Pessoas
- http://localhost:8080/pessoas/
- Objetivo: Criar uma pessoa
- input exemplo:
``` json
{
  "nome": "Nome teste",
  "data_nascimento": "1999-06-20",
  "enderecos":[
    {
      "cep": "48462687",
      "numero": 8452,
      "cidade": "Brasilia",
      "principal": false,
      "logradouro": "Rua 24"
    },
    {
      "cep": "12345678",
      "numero": 5,
      "cidade": "Anapolis",
      "principal": false,
      "logradouro": "Rua 4"
    }
  ]
}
```

- retorno do exemplo:

(Como não foi informado o endereço principal, o primeiro é escolhido.)
		
``` json
{
	"id": 4,
	"nome": "Nome teste",
	"data_nascimento": "1999-06-20",
	"enderecos": [
		{
			"id": 7,
			"cep": "48462687",
			"numero": 8452,
			"cidade": "Brasilia",
			"principal": true,
			"logradouro": "Rua 24"
		},
		{
			"id": 8,
			"cep": "12345678",
			"numero": 5,
			"cidade": "Anapolis",
			"principal": false,
			"logradouro": "Rua 4"
		}
	],
	"principalEndereco": {
		"id": 7,
		"cep": "48462687",
		"numero": 8452,
		"cidade": "Brasilia",
		"principal": true,
		"logradouro": "Rua 24"
	}
}
```
### PUT pessoa
- http://localhost:8080/pessoas/
- Objetivo: Editar pessoa
- input exemplo:
``` json
{
  "id": 4,
  "nome": "Outro nome",
  "data_nascimento": "2000-07-20",
  "enderecos":[
    {
      "cep": "12355844",
      "numero": 3,
      "cidade": "Brasilia",
      "principal": false,
      "logradouro": "Rua 7"
    },
    {
      "cep": "986754",
      "numero": 9,
      "cidade": "Anapolis",
      "principal": true,
      "logradouro": "Rua Marcelo Andrade"
    }
  ]
}
```

- Retorno do exemplo :
``` json
{
	"id": 4,
	"nome": "Outro nome",
	"data_nascimento": "2000-07-20",
	"enderecos": [
		{
			"id": 11,
			"cep": "12355844",
			"numero": 3,
			"cidade": "Brasilia",
			"principal": false,
			"logradouro": "Rua 7"
		},
		{
			"id": 12,
			"cep": "986754",
			"numero": 9,
			"cidade": "Anapolis",
			"principal": true,
			"logradouro": "Rua Marcelo Andrade"
		}
	],
	"principalEndereco": {
		"id": 12,
		"cep": "986754",
		"numero": 9,
		"cidade": "Anapolis",
		"principal": true,
		"logradouro": "Rua Marcelo Andrade"
	}
}
```
### GET pessoa
- http://localhost:8080/pessoas/{pessoaId}
- Objetivo: Consultar uma pessoa
- input exemplo: (Id da pessoa na url)
```
pessoaId = 4
```

- Retorno do exemplo :
``` json
{
	"id": 4,
	"nome": "Outro nome",
	"data_nascimento": "2000-07-20",
	"enderecos": [
		{
			"id": 11,
			"cep": "12355844",
			"numero": 3,
			"cidade": "Brasilia",
			"principal": false,
			"logradouro": "Rua 7"
		},
		{
			"id": 12,
			"cep": "986754",
			"numero": 9,
			"cidade": "Anapolis",
			"principal": true,
			"logradouro": "Rua Marcelo Andrade"
		}
	],
	"principalEndereco": {
		"id": 12,
		"cep": "986754",
		"numero": 9,
		"cidade": "Anapolis",
		"principal": true,
		"logradouro": "Rua Marcelo Andrade"
	}
}
```

### PUT endereço para pessoa
- http://localhost:8080/pessoas/{pessoaId}/enderecos
- Objetivo: Adicionar endereço a pessoa
- input exemplo: 
```
pessoaId = 4
```
``` json
{
	"cep": "48462688",
	"numero": 8452,
	"cidade": "Brasilia",
	"principal": true,
	"logradouro": "Rua 24"
}
```

- Retorno do exemplo :
``` json
{
	"id": 4,
	"nome": "Outro nome",
	"data_nascimento": "2000-07-20",
	"enderecos": [
		{
			"id": 11,
			"cep": "12355844",
			"numero": 3,
			"cidade": "Brasilia",
			"principal": false,
			"logradouro": "Rua 7"
		},
		{
			"id": 12,
			"cep": "986754",
			"numero": 9,
			"cidade": "Anapolis",
			"principal": false,
			"logradouro": "Rua Marcelo Andrade"
		},
		{
			"id": 13,
			"cep": "48462688",
			"numero": 8452,
			"cidade": "Brasilia",
			"principal": true,
			"logradouro": "Rua 24"
		}
	],
	"principalEndereco": {
		"id": 13,
		"cep": "48462688",
		"numero": 8452,
		"cidade": "Brasilia",
		"principal": true,
		"logradouro": "Rua 24"
	}
}
```

### GET endereços da pessoa
- http://localhost:8080/pessoas/{pessoaId}/enderecos
- Objetivo: Editar pessoa
- input exemplo:
``` 
pessoaId = 4
```

- Retorno do exemplo :
``` json
[
	{
		"id": 11,
		"cep": "12355844",
		"numero": 3,
		"cidade": "Brasilia",
		"principal": false,
		"logradouro": "Rua 7"
	},
	{
		"id": 12,
		"cep": "986754",
		"numero": 9,
		"cidade": "Anapolis",
		"principal": false,
		"logradouro": "Rua Marcelo Andrade"
	},
	{
		"id": 13,
		"cep": "48462688",
		"numero": 8452,
		"cidade": "Brasilia",
		"principal": true,
		"logradouro": "Rua 24"
	}
]
```
### Get endereço principal
- http://localhost:8080/pessoas/{pessoaId}/principalendereco
- Objetivo: Informar qual endereço é o principal da pessoa  
- input exemplo:
```
pessoaId = 4
```

- Retorno do exemplo :
``` json
{
	"id": 13,
	"cep": "48462688",
	"numero": 8452,
	"cidade": "Brasilia",
	"principal": true,
	"logradouro": "Rua 24"
}
```

