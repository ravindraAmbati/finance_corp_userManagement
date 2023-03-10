package corp.finance.UserManagement.controller;

import corp.finance.UserManagement.config.ServiceConfig;
import corp.finance.UserManagement.model.Properties;
import corp.finance.UserManagement.model.User;
import corp.finance.UserManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    private final ServiceConfig serviceConfig;

    @GetMapping("/all")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/ids")
    public @ResponseBody List<User> getUsers(@RequestBody List<String> userIds) {
        return userService.getUsers(userIds);
    }

    @GetMapping("/{userId}")
    public @ResponseBody User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/properties")
    public @ResponseBody Properties getProperties() {
        return new Properties(serviceConfig.getMessage(), serviceConfig.getBuildVersion(), serviceConfig.getMailDetails());
    }
}
