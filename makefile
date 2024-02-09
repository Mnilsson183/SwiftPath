make:

build:
	javac *.java -d build/

count:
	git ls-files | xargs wc -l

clean:
	rm -rf build/*