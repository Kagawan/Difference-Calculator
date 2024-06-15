DEFAULT_GOAL := build-run

#setup:
#	./gradlew wrapper --gradle-version 8.5

#clean:
#	./gradlew clean

build:
	./gradlew build

install:
	./gradlew installDist
run-dist:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app
run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

#check-deps:
#	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build