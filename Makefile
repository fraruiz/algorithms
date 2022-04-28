.PHONY: all
all: build

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: test
test:
	@./gradlew test --warning-mode all

# Start the app
.PHONY: start-consumer
start-consumer:
	@./gradlew :run --args='consumer'

.PHONY: start-api
start-api:
	@./gradlew :run --args='api'
