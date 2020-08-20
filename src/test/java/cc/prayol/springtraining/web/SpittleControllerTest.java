package cc.prayol.springtraining.web;

import cc.prayol.springtraining.data.Spittle;
import cc.prayol.springtraining.repository.SpittleRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpittleControllerTest {

    @Test
    public void spittles() throws Exception {
        List<Spittle> spittleList = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(spittleList);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("/WEB-INFO/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittleList.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        ArrayList<Spittle> spittles = Lists.newArrayListWithExpectedSize(count);
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("spittle+" + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void abb(){
        BigDecimal bigDecimal = new BigDecimal("10000.00");
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.precision());
        System.out.println(bigDecimal.unscaledValue());

        LinkedHashSet<String> objects = Sets.newLinkedHashSetWithExpectedSize(3);
        Queue<String> a = new LinkedList<String>();

    }
}