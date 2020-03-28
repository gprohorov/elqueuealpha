package com.med.elqueuealpha;

import com.med.elqueuealpha.model.total.TotalWorkDay;
import com.med.elqueuealpha.model.total.TotalWorkMonth;
import com.med.elqueuealpha.model.total.TotalWorkWeek;
import com.med.elqueuealpha.service.TotalWorkDayService;
import com.med.elqueuealpha.service.TotalWorkMonthService;
import com.med.elqueuealpha.service.TotalWorkWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@Controller
public class ControllerWeb {
    private final TotalWorkDayService totalWorkDayService;
    private final TotalWorkWeekService totalWorkWeekService;
    private final TotalWorkMonthService totalWorkMonthService;

    @Autowired
    public ControllerWeb(TotalWorkDayService totalWorkDayService
            , TotalWorkWeekService totalWorkWeekService
            , TotalWorkMonthService totalWorkMonthService) {
        this.totalWorkDayService = totalWorkDayService;
        this.totalWorkWeekService = totalWorkWeekService;
        this.totalWorkMonthService = totalWorkMonthService;
    }

    @RequestMapping(value = "/day", method = RequestMethod.GET)
    public String showDaysAll(Model model){
        List<TotalWorkDay> list = totalWorkDayService.getAll();
        Collections.reverse(list);
        model.addAttribute("totals", list);
        return "totalWorkDay";
    }

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public String showWeeksAll(Model model){
        List<TotalWorkWeek> list = totalWorkWeekService.getAll();
        Collections.reverse(list);
        model.addAttribute("totals", list);
        return "totalWorkWeek";
    }

    @RequestMapping(value = "/month", method = RequestMethod.GET)
    public String showMonthsAll(Model model){
        List<TotalWorkMonth> list = totalWorkMonthService.getAll();
        model.addAttribute("totals", list);
        return "totalWorkMonth";
    }

    // сброс и заполнения по дням
    @RequestMapping(value = "/generate/day", method = RequestMethod.GET)
    public String setGenerateDay(){
        totalWorkDayService.setStart();
        return "redirect:/day";
    }

    // сброс и заполнения по неделям
    @RequestMapping(value = "/generate/week", method = RequestMethod.GET)
    public String setGenerateWeek(){
        totalWorkWeekService.setStart();
        return "redirect:/week";
    }

    // сброс и заполнения по месяцам
    @RequestMapping(value = "/generate/month", method = RequestMethod.GET)
    public String setGenerateMonth(){
        totalWorkMonthService.setStart();
        return "redirect:/month";
    }

    //за все время
    @RequestMapping(value = "/generate/weekF", method = RequestMethod.GET)
    public String setGenerateWeekFull(){
        totalWorkWeekService.setStartFull();
        return "redirect:/week";
    }

    //за все время
    @RequestMapping(value = "/generate/monthF", method = RequestMethod.GET)
    public String setGenerateMonthFull(){
        totalWorkMonthService.setStartFull();
        return "redirect:/month";
    }
}
