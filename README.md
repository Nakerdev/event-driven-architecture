## Start
docker-compose up

## Description

## Start dev environment
docker-compose -f docker-compose-dev.yml -p event_driven_arquitecture up -d

## TODO

- The AddUserRequestDto is the controller Request model (infrastructure), why is it int the user application layer? Could
be better into the controller file? The controller should convert from controller request to command request.
- Should the command request be coupled to controller request model? Is it break the dependency arrow?
- Should interface starts with "I"? -> IUserRepository
- Should events have the "Event" suffix? -> UserCreatedEvent
- Should controllers have the http verb as prefix? -> PostUpdateUserController
- Might we use DDD as folder structure convention in the webapp? 
  - Use users.controllers.api.postUpdateUserController instead of controllers.postUpdateUserController (the domain context (Users) is in the first level)