# Hamlet-feed
This application publishes a simple feed with sentences from William Shakespeare's Hamlet. Why, you ask? To test a new data pipeline in SSBs magnificent data platform!

## How it works
It's simple! A text-file in `/resources` in loaded into memory on start-up. Each sentence is split into single rows with an increasing number as key. The data is published to the endpoint `http://localhost:8080/feed` (the URL may change if you run it in an environment, say on BIP or similar container-based platforms).

Actuator is activated, exposing health on `/actuator/health` and metrics `/actuator/metrics`.