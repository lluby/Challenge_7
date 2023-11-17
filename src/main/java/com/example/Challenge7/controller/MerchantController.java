package com.example.Challenge7.controller;

import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.service.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RequestMapping(value = "/api/merchant")
@RestController
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Api to get all merchant")
    public List<Merchant> getMerchant() {
        return merchantService.getAllMerchant();
    }

    @PostMapping(value = "add-merchant")
    public ResponseEntity addMerchant(@RequestBody Merchant merchant){
        merchantService.addMerchant(Merchant.builder()
                .MerchantCode(merchant.getMerchantCode())
                .MerchantName(merchant.getMerchantName())
                .MerchantLocation(merchant.getMerchantLocation())
                .open(merchant.isOpen())
                .build());
        return ResponseEntity.ok("Merchant added successfully");
    }
    @PostMapping(value = "update-merchant")
    public ResponseEntity updateMerchant(@RequestBody Merchant merchant) {
        Merchant updatedMerchant = merchantService.updateMerchant(merchant);
        if (updatedMerchant != null) {
            return new ResponseEntity<>(updatedMerchant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to update merchant", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{MerchantCode}")
    public String deleteMerchant(@PathVariable("MerchantCode") String MerchantCode) {
        merchantService.deleteMerchant(MerchantCode);
        return "Delete merchant " + MerchantCode + " success!";
    }

    @GetMapping("/detail/{merchantCode}")
    @Secured(value = "ROLE_USER")
    public ResponseEntity getMerchantDetail(@PathVariable String merchantCode) {
        Merchant merchant = merchantService.getMerchantDetail(merchantCode);
        if (merchant != null) {
            return new ResponseEntity<>(merchant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Merchant not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/detail")
    @Operation(summary = "Getting detail of one merchant by merchant code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Merchant found"),
            @ApiResponse(responseCode = "404", description = "Inputted merchant code not found")
    })

    private List<?> testWildCard(){
        return Arrays.asList("String", 40);
    }

}
