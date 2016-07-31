package com.testrbc.petshop;

import com.testrbc.petshop.domain.Pet;
import com.testrbc.petshop.security.AdminService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(basePath = "/pet", value = "Pet", description = "Operations with Pets", produces = "application/json")
@RestController
@RequestMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetShopRestController {
    @Autowired
    AdminService adminService;

    @ApiOperation(value = "admin", notes = "verify if admin rights are granted")
    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String admin() {
        adminService.ensureAdmin();
        return "admin";
    }

    @ApiOperation(value = "getPet", nickname = "getPet")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "petId", value = "Pet ID", required = true, dataType = "string", paramType = "query", defaultValue="")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Pet.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/{petId}")
    public String getPetById(@PathVariable String petId) {
        return "getPetById";
    }
}
