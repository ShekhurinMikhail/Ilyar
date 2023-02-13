package web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.DAOCarlmpl;
import web.service.CarServicelmpl;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pages")
public class CarController {
    @Autowired
    private CarServicelmpl carServicelmpl;
//    @GetMapping("cars")
//    public String index(Model model) {
//        model.addAttribute("car",carServicelmpl.index());
//        return "index.html";
//    }
    @GetMapping("cars")
    public String show(@RequestParam(value = "count", required = false) String count, Model model) {
        if (count==null) {
            model.addAttribute("car", carServicelmpl.index());
            return "show.html";
        } else {
            model.addAttribute("car", carServicelmpl.show(Integer.parseInt(count)));
            return "show.html";
        }
    }
}
