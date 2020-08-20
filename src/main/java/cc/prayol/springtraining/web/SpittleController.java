package cc.prayol.springtraining.web;

import cc.prayol.springtraining.data.Spittle;
import cc.prayol.springtraining.repository.SpittleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author hjx
 * @date 2020/8/14
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private final SpittleRepository spittleRepository;

    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles() {
        return spittleRepository.findSpittles(Long.MAX_VALUE,20);
    }
}
