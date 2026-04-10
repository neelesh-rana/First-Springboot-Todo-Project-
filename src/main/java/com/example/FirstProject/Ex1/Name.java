package com.example.FirstProject.Ex1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Name {



    private static List<NameEntity>  getinfo;




    public  Name(){
      getinfo = new ArrayList<>();

      getinfo.add(new NameEntity("neelesh ",01 , "1SP23CS061" ));

    }






    //Get the  info
    @GetMapping("/info")
    public List<NameEntity> GetInfo (){
        return  getinfo;

    }

    //Create the info
    @PostMapping("/info ")   //Creatig the response status using the responseEntity
    public ResponseEntity <NameEntity> createName(@RequestBody NameEntity nameList){

        getinfo.add(nameList);
        return  ResponseEntity.status(HttpStatus.OK).body(nameList);

    }


    @DeleteMapping("/info")

    public NameEntity deleteName(@PathVariable NameEntity nameEntity){

        getinfo.remove(nameEntity);

        return  nameEntity;

    }




}
