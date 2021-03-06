package nl.actorcatalogue;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ActorControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ActorRepository actorRepository;

    @Test
    public void exampleTest() throws Exception {
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setName("testActor");
        actor.setDescription("just for test");
        when(actorRepository.getAllActors()).thenReturn(Arrays.asList(actor));
        this.mvc.perform(get("/actor").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"testActor\",\"description\":\"just for test\"}]"));
    }
}
