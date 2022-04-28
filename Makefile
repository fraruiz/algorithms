.PHONY: all
all: build

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: test
test:
	@./gradlew test --warning-mode all
