run-dist:
	make -C app run-dist
test:
	make -C app test
report:
	make -C app report
run:
	make -C app linter
.PHONY: build