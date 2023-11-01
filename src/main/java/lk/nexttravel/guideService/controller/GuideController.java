package lk.nexttravel.guideService.controller;

import lk.nexttravel.guideService.dto.GuideDto;
import lk.nexttravel.guideService.service.GuideService;
import lk.nexttravel.guideService.util.IdGenerator;
import lk.nexttravel.guideService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nexttravel/guide/service")
@CrossOrigin
public class GuideController { 

    @Autowired
    GuideService guideService;



    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGuide(@RequestPart String guideName, @RequestPart String address,
                                  @RequestPart String guideAge, @RequestPart String gender,
                                  @RequestPart String contactNo,@RequestPart byte[] guideImg, @RequestPart byte[] guideIdImg,
                                  @RequestPart String experience, @RequestPart String value){


        IdGenerator idGenerator = new IdGenerator();
        String guideId = idGenerator.generateID();

        Integer age = Integer.valueOf(guideAge);
        double dayValue = Double.parseDouble(value);


        GuideDto guideDto = new GuideDto(guideId,guideName, address, age,
                gender, contactNo, guideImg, guideIdImg, experience, dayValue);

        guideService.saveGuide(guideDto);

        return new ResponseUtil(200,"Guide Save",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGuide(@RequestPart String guideId,@RequestPart String guideName,@RequestPart String address,
                                    @RequestPart String guideAge, @RequestPart String gender,
                                    @RequestPart String contactNo, @RequestPart byte[] guideImg,
                                    @RequestPart byte[] guideIdImg, @RequestPart String experience,
                                    @RequestPart String value){

        Integer age = Integer.valueOf(guideAge);
        double dayValue = Double.parseDouble(value);


        GuideDto guideDto = new GuideDto(guideId,guideName, address, age,
                gender, contactNo, guideImg, guideIdImg, experience, dayValue);

        guideService.updateGuide(guideDto);

        return new ResponseUtil(200,"Update Success",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGuides(){
        List<GuideDto> allGuide = guideService.getAllGuide();
        return new ResponseUtil(200,"Get All Success",allGuide);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteGuide(@RequestParam String id){
        guideService.deleteGuide(id);
        return new ResponseUtil(200,"Delete Success",null);
    }

    @GetMapping(value = "/{id}")
    public ResponseUtil searchGuide(@PathVariable String id){
        GuideDto guideDto = guideService.searchGuide(id);
        return new ResponseUtil(200,"Search Success",guideDto);
    }
}
