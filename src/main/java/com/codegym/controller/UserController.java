package com.codegym.controller;

//import com.codegym.service.CustomerService;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        } else{
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }
    }

//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("/create")
//    public ModelAndView getIndex(){
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.save(customer);
//
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer",new Customer());
//        modelAndView.addObject("message","New customer created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/customers")
//    public ModelAndView listCustomers(){
//        List<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//    @GetMapping("/edit/{id}")//load form include information Customer
//    public ModelAndView showEditForm(@PathVariable int id){
//        Customer customer = customerService.findById(id);
//        if(customer !=null){
//            ModelAndView modelAndView =  new ModelAndView("/customer/edit");
//            modelAndView.addObject("customer",customer);
//            return modelAndView;
//        } else{
//            ModelAndView modelAndView = new ModelAndView("/customer/error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable int id){
//        Customer customer = customerService.findById(id);
//        if(customer != null){
//            ModelAndView modelAndView = new ModelAndView("/customer/delete");
//            modelAndView.addObject("customer",customer);
//            return modelAndView;
//        } else{
//            ModelAndView modelAndView = new ModelAndView("/customer/error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("delete")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.remove(customer.getId());
//        return "redirect:customers";
//    }


}
