package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jdbcTemplate.DAO.UserDaoImpl;
import Model.User;


@Controller
public class LoginController {

    @Autowired
    private UserDaoImpl userDao;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsp/index");
        return mv;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "form-username") String username,
                              @RequestParam(value = "form-password") String password
                              ){

        User user = userDao.get(username,password);
        if(user != null){
            ModelAndView mv = new ModelAndView("jsp/success");
            mv.addObject("username",user.getUsername());
            return mv;
        }
        else {
            ModelAndView mv = new ModelAndView("jsp/error");
            return mv;
        }
    }


}
