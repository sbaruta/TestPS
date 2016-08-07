package com.testrbc.petshop;

import com.testrbc.petshop.domain.Pet;
import com.testrbc.petshop.services.PetService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(basePath = "/pet", value = "Pet", description = "Operations with Pets", produces = "application/json")
@RestController
@RequestMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetShopRestController {
    @Autowired
    PetService petService;

    @ApiOperation(value = "getPet", nickname = "getPet")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "petId", value = "Pet ID", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Pet.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable String petId) {
        System.out.println(petId);
        Pet pet = petService.findById(petId);
        if (pet != null) {
            return new ResponseEntity<>(pet, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "deletePet", nickname = "deletePet")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "petId", value = "Pet ID", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = RequestMethod.DELETE, path = "/{petId}")
    @PreAuthorize("hasRole(@roles.ADMIN)")
    public ResponseEntity<Boolean> deletePetById(@PathVariable String petId) {
        System.out.println(petId);
        Pet pet = petService.findById(petId);
        if (pet != null) {
            petService.delete(pet);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "addPet", nickname = "addPet")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = RequestMethod.POST, path = "/")
    @PreAuthorize("hasRole(@roles.ADMIN)")
    public ResponseEntity<Boolean> addPet(@RequestBody Pet pet) {
        System.out.println(pet);
        if (petService.save(pet) != null) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }
}
