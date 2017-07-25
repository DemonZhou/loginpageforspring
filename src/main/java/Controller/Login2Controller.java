package Controller;

import Model.User;
import ibatis.DAO.IbatisUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login2Controller {

    @Autowired
    private IbatisUserDaoImpl IbatisUserDao;
    @RequestMapping(value="/login2"  ,method = RequestMethod.GET)
    public ModelAndView index2(){
        ModelAndView mv = new ModelAndView("jsp/index");
        return mv;
    }

    @RequestMapping(value="/login2",method = RequestMethod.POST)
    public ModelAndView login2(@RequestParam(value = "form-username") String username,
                               @RequestParam(value = "form-password") String password
    ){
        User user = IbatisUserDao.get(username,password);
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
