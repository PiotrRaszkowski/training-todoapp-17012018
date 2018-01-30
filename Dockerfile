FROM airhacks/glassfish
COPY ./target/todoapp.war ${DEPLOYMENT_DIR}
