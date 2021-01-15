package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class CommentController {

  @Autowired
  CommentService commentService;

  @Autowired
  ImageService imageService;

  @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
  public String updateComments(@PathVariable("imageId") String imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String commentStr, HttpSession session){
    User loggedUser=(User)session.getAttribute("loggeduser");
    Image image = imageService.getImage(Integer.valueOf(imageId));
    System.out.println(image.getTitle());
    Comment comment=new Comment();
    comment.setText(commentStr);
    comment.setUser(loggedUser);
    comment.setImage(image);
    comment.setCreatedDate(new Date());

    commentService.uploadComment(comment);

    return "redirect:/images/"+imageId+"/"+imageTitle;

  }


}
