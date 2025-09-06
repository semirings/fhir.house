A webapp that runs locally like an electron desktop but can be staged on an http server.
It presents a web page that supports the upload of a FHIR profile then upon the user's command, it generates an implementation of said profile in the language the user selected.  It returns the source code of the implementation to the user.

Any given implementation that is based on the same profile and populated with the same data, serializes identically with any other and always conforms to the FHIR specification.
