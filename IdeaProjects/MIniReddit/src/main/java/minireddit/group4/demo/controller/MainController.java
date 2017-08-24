package minireddit.group4.demo.controller;


import minireddit.group4.demo.model.Reddit;
import minireddit.group4.demo.repository.RedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class MainController

{
    @Autowired
    RedditRepository redditRepository;

    @GetMapping("/")
    public String getMainPage()
    {
        return "index";
    }


    @GetMapping("/entryform")
    public String getEntry(Model model)
    {
        model.addAttribute("newReddit", new Reddit());
        return "entryform";
    }

    @PostMapping("/entryform")
    public String postForm(@ModelAttribute("newReddit") Reddit otherreddit, Model model)
    {

        Date date=new Date();
       model.addAttribute("new", otherreddit);
        otherreddit.setDate(date);
        redditRepository.save(otherreddit);

       return "confirm";
    }

    @GetMapping("/showall")
    public String getShowAll(Model model)
    {
        Iterable<Reddit> rd =  redditRepository.findAll();
        model.addAttribute("redobj", rd);
        return "showall";
    }
}
