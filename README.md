# hello-function

## Install Azure CLI

```
brew tap azure/functions
brew install azure-functions-core-tools
```

## Build a function

```
mvn clean package -DskipTests=true
```

## Run Locally

```
mvn azure-functions:run
```

```
$ curl -H "Content-Type: text/plain"  http://localhost:7071/api/hello -d making -w '\n'
Hello making!
```

## Deploy

```
az login
mvn azure-functions:deploy
```

```
$ curl -H "Content-Type: text/plain"  https://s1pfunction.azurewebsites.net/api/hello -d making -w '\n'
Hello making!
```