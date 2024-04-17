FROM gradle:jdk20

WORKDIR /

COPY / .

RUN gradle installDist

CMD ./build/install/app/bin/
