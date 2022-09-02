package com.test.controller;

import com.test.domain.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
//在这里加上的话,表示下面返回的全都是body
@ResponseBody
//@RestController 表示@Controller与@ResponseBody,两者结合起来
public class UserController {
    //由于是post操作,直接把RequestMapping改成postMapping
    @PostMapping()
    public String save(){
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    //@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("user delete..." + id);
        return "{'module':'user delete'}";
    }

    @PutMapping
    public String update(@RequestBody user user){
        System.out.println("user update..."+user);
        return "{'module':'user update'}";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id){
        System.out.println("user getById..."+id);
        return "{'module':'user getById'}";
    }


    @GetMapping
    public String getAll(){
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }

}

