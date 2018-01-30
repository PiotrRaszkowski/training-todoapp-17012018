# Build
mvn clean package && docker build -t pl.jitsolutions.training/todoapp .

# RUN

docker rm -f todoapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name todoapp pl.jitsolutions.training/todoapp 