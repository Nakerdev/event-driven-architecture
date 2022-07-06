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