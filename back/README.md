## Levantar BD: ```docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=jota -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=sanfelipe -d postgres:15-alpine```
# Endpoints
## Obtener Clientes: ```http://localhost:8080/clients```
## Registrar Cliente: ```[POST]http://localhost:8080/clients/register```

# Crear PR
## Clonar el repo: 
- `git clone https://github.com/DanisaurioRex/sanfelipe.git`
- `cd sanfelipe\`

## Crear rama:
- `git checkout -b rama_adicionar_entidates`
- `git remote add upstream https://github.com/DanisaurioRex/sanfelipe.git`

## Hacer las modificaciones
## Adicionar todos los nuevos cambios
- `git add .`

## Hacer commit con un mensaje
- `git commit -S -m "Adicionando nuevas entidades"`

## Subir tu rama local al servidor de github
- `git push -u origin rama_adicionar_entidates`