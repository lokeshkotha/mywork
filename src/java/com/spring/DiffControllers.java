/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lokesh Kotha
 */
public class DiffControllers {

//    @RequestMapping(value = "/getcampaignbyid", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    Campaigns getCampaignById(@RequestBody String campaignId) {
//        return campaignServices.getCampaignById(campaignId);
//    }
//    @RequestMapping(value = "/addcampaigndetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    ServiceStatus getAvailableZipcodes(@RequestBody AddCampaingRequest addCampaingRequestObj) {
//        return campaignServices.addCampaignDetails(addCampaingRequestObj);
//    }
//    @RequestMapping(value = "/foo/bar/{barId}/bing")
//    public void handle(@PathVariable("barId") Long barId, @RequestParam("blam") blamParameter) {
//    }
    //   @RequestMapping(method = RequestMethod.GET)
//   @ResponseBody
//   public List<Foo> findAll() {
//       return service.findAll();
//   }
//   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//   @ResponseBody
//   public Foo findOne(@PathVariable("id") Long id) {
//       return RestPreconditions.checkFound( service.findOne( id ));
//   }
// 
//   @RequestMapping(method = RequestMethod.POST)
//   @ResponseStatus(HttpStatus.CREATED)
//   @ResponseBody
//   public Long create(@RequestBody Foo resource) {
//       Preconditions.checkNotNull(resource);
//       return service.create(resource);
//   }
// 
//   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//   @ResponseStatus(HttpStatus.OK)
//   public void update(@PathVariable( "id" ) Long id, @RequestBody Foo resource) {
//       Preconditions.checkNotNull(resource);
//       RestPreconditions.checkNotNull(service.getById( resource.getId()));
//       service.update(resource);
//   }
// 
//   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//   @ResponseStatus(HttpStatus.OK)
//   public void delete(@PathVariable("id") Long id) {
//       service.deleteById(id);
//   }
//    @Bean(name = "multipartResolver")
//    @RequestMapping(value = "/uploadbigimage", method = RequestMethod.POST)
//    public @ResponseBody
//    String handleFileUploadBigImage(@RequestParam("bigimage") MultipartFile file, @RequestParam("productid") String productid, @RequestParam("returnurl") String returnurl) {
//
////        CompanyConfig cc = adminServices.getCompanyConfigById("1");
//        if (!file.isEmpty()) {
//            try {
//                String extension = "";
//                String filetype = file.getContentType();
//                if (filetype.toLowerCase().equals("image/jpeg")) {
//                    extension = ".jpg";
//                } else if (filetype.toLowerCase().equals("image/png")) {
//                    extension = ".png";
//                }
//                byte[] bytes = file.getBytes();
////                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(cc.getBigproductpath() + productid + extension)));
////                stream.write(bytes);
////                stream.close();
////                adminServices.updateBigImage(productid, cc.getBigproducturl() + productid + extension);
//                return "Image successfully uploaded! <meta http-equiv=\"refresh\" content=\"0; URL=" + returnurl + "\"></meta>";
//            } catch (Exception e) {
//                return "You failed to upload  => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload because the file was empty.";
//        }
//    }
//     @RequestMapping(value = "/getcitiesbyregionid/{regionId}", method = RequestMethod.GET)
//    public @ResponseBody
//    CitiesList getCitiesByRegionId(@PathVariable String regionId) {
//        CitiesList<CityDTResponse> list = new CitiesList<>(utilityDAO.getCitiesByRegion(regionId));
//        return list;
//    }
}
