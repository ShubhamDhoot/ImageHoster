package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class CommentService {

  @Autowired
  CommentRepository commentRepository;

  public void uploadComment(Comment comment){
    commentRepository.uploadComment(comment);
  }

}
