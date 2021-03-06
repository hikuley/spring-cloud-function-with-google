
=== Google Cloud Functions Sample Application

===== Test locally

Run the function:

----
mvn function:run
----

Invoke the HTTP function:

----
curl http://localhost:8080/ -d "hello"
----

===== Deploy to GCP

As of March 2020, Google Cloud Functions for Java is in Alpha.
You can get on the https://docs.google.com/forms/d/e/1FAIpQLScC98jGi7CfG0n3UYlj7Xad8XScvZC8-BBOg7Pk3uSZx_2cdQ/viewform[whitelist] to try it out.

Package the application.

----
mvn package
----

You should see the fat jar in the `target/deploy` directory.

Make sure that you have the https://cloud.google.com/sdk/install[Cloud SDK CLI] installed.

Run the following command from the project root to deploy.

----
gcloud alpha functions deploy function-sample-gcp-http \
--entry-point org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
--runtime java11 \
--trigger-http \
--source target/deploy \
--memory 512MB
----

Invoke the HTTP function:

----
curl https://REGION-PROJECT_ID.cloudfunctions.net/function-sample-gcp-http -d "hello"
----