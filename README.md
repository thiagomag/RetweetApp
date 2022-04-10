## Calling Twitter Api with SpringBoot, OpenFeign and Twittered.

This app use Spring Boot to create an api that call the Twitter API
to search tweets that have a certain phrase that is passed through
a Path Param and then retweet it.

To search the tweets is used OpenFeign, which is easy to make 
a call to the urls that don't need authentication or needs only bearer token.

To make the retweet is used Twittered, a lib that simplify the call to urls
that need oauth authentication.

For the view is used Swagger-UI.