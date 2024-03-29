package com.dimon.controller;

import com.dimon.DTO.impl.MessageDTO;
import com.dimon.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchTeamException.class)
    ResponseEntity<MessageDTO> handleNoSushCityException(){
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such city not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchReplacementException.class)
    ResponseEntity<MessageDTO> handleNoSushPersonException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such person not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchPlayerException.class)
    ResponseEntity<MessageDTO> handleNoSushBookException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such book not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistsPlayersForTeamException.class)
    ResponseEntity<MessageDTO> handleExistsPersonsForCityException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Delete imposible. There are persons for this city"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistsPlayerForProjectException.class)
    ResponseEntity<MessageDTO> handleExistsBooksForPersonException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Delete imposible. There are books for this person"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistsReplacementForPlayerException.class)
    ResponseEntity<MessageDTO> handleExistsPersonsForBookException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Delete imposible. There are persons for this book"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AlreadyExistsPlayerInReplacementException.class)
    ResponseEntity<MessageDTO> handleAlreadyExistsBookInPersonExceptionException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Add imposible. The person already contain this book"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PlayerAbsentException.class)
    ResponseEntity<MessageDTO> handleBookAbsentException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Now this book is absent"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReplacementHasNotPlayerException.class)
    ResponseEntity<MessageDTO> handlePersonHasNotBookException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("The person hasn't this book"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchLogException.class)
    ResponseEntity<MessageDTO> handleNoSuchLogException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such log not found"), HttpStatus.NOT_FOUND);
    }

}
