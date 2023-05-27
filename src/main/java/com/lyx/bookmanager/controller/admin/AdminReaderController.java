package com.lyx.bookmanager.controller.admin;

import com.lyx.bookmanager.mapper.ReaderMapper;
import com.lyx.bookmanager.pojo.Book;
import com.lyx.bookmanager.pojo.Reader;
import com.lyx.bookmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/reader")
public class AdminReaderController {

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Reader> readers = readerMapper.getAllReader();
        model.addAttribute("readers", readers);
        return "admin/readers";
    }
    @RequestMapping("/borrow")
    public String borrow(@RequestParam("readerId") String readerId) {
        System.out.println("Reader ID: " + readerId);
        // 在这里可以使用 readerId 进行后续处理
        readerMapper.updateBorrow(readerId);
        return "redirect:/admin/reader/getAll";
    }

    @RequestMapping("/stop")
    public String stop(@RequestParam("readerId") String readerId) {
        System.out.println("Reader ID: " + readerId);
        // 在这里可以使用 readerId 进行停借操作
        readerMapper.updateStop(readerId);
        return "redirect:/admin/reader/getAll";
    }
}
