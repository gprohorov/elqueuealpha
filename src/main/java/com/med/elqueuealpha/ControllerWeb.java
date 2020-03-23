package com.med.elqueuealpha;
import com.med.elqueuealpha.model.TotalWorkDay;
import com.med.elqueuealpha.service.TotalWorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@CrossOrigin("*")
@Controller
public class ControllerWeb {
    private final TotalWorkDayService totalWorkDayService;

    @Autowired
    public ControllerWeb(TotalWorkDayService totalWorkDayService) {
        this.totalWorkDayService = totalWorkDayService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showTotalAll(Model model){
        List<TotalWorkDay> list = totalWorkDayService.getAll();
        model.addAttribute("total", list);
        return "totalWorkDay";
    }
}
