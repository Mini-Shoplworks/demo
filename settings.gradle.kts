rootProject.name = "demo"

include("service-starter:web")
include("service-starter:data-jpa")
include("services:management")
include("service-starter:json")
findProject(":service-starter:json")?.name = "json"
