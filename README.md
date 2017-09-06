This is a project to run a set of UI regression tests against the transiTime web interface.

It needs [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/home) installed on the local machine to run. This will need to be in your PATH.

To run the tests  

```
mvn -DargLine="-Dbaseurl=http://127.0.0.1:8080/web" install
```

This will run the tests against a transiTime install at http://127.0.0.1:8080/web. You can change this to be any URL where transiTime is installed to test it.