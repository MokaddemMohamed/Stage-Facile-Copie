package com.projet.annuaire.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.model.Reply;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.User;
import com.projet.annuaire.model.Vote;
import com.projet.annuaire.service.EmailSenderService;
import com.projet.annuaire.service.ReplyService;
import com.projet.annuaire.service.SecurityService;
import com.projet.annuaire.service.StageService;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.service.VoteService;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Controller
public class ReplyController {

	@Autowired
	private StageService stageService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private ReplyService replyService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailSenderService emailSenderService;

	/**
	 * Request method GET with requestmapping value = /stage/details/{id}/reply
	 * 
	 * @param replyForm reply form to get the new reply to add
	 * @param model     entity used in jsp page
	 * @param id        entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/reply/add/{id}" }, method = RequestMethod.POST)
	public String addReply(@ModelAttribute("newReply") Reply replyForm, Model model, @PathVariable Long id) {
		Stage stage = stageService.findById(id);

		Reply newReply = new Reply();
		newReply.setReply(replyForm.getReply());
		newReply.setComment(stage.getComment());
		newReply.setUsername(securityService.findLoggedInUser());
		newReply.setVote(0);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		newReply.setDate(new Date());
		newReply.setFormatedDate(simpleDateFormat.format(new Date()));

		replyService.save(newReply);

		// Sending an email to the stage's author to inform him/her
		emailSenderService.prepareAndSendEmail(stageService.findById(id).getUser().getMail(),
				"Stage Facile : Nouveau commentaire",
				"Un utilisateur a laissé un avis sur votre stage " + stage.getSubject() + " effectué à "
						+ stage.getEnterprise().getName() + " : \n\"" + replyForm.getReply()
						+ "\"\nCliquez ici pour voir cet avis sur le site : http://localhost:8080/stage/details/" + id);

		return "redirect:/stage/details/" + id;
	}

	/**
	 * Request method GET with requestmapping value = /reply/delete/{id}
	 * 
	 * @param model entity used in jsp page
	 * @param id    reply id
	 * @return page name
	 */
	@RequestMapping(value = { "/reply/delete/{id}" }, method = RequestMethod.GET)
	public String deleteReply(Model model, @PathVariable Long id) {
		// Prevent to delete reply if you're not the author
		Reply toBeDeleted = replyService.findById(id);
		if (!toBeDeleted.getUsername().equals(securityService.findLoggedInUser())) {
			model.addAttribute("error", "403");
			return "redirect:/error";
		}

		voteService.deleteByReplyId(id);
		replyService.deleteById(id);
		return "redirect:/stage/details/" + toBeDeleted.getComment().getStage().getId();
	}

	/**
	 * Request method GET with requestmapping value = /reply/upvote/{id}/{username}
	 * 
	 * @param model    entity used in jsp page
	 * @param id       reply id
	 * @param username user username
	 * @return
	 */
	@RequestMapping(value = { "reply/upvote/{id}/{username}" }, method = RequestMethod.GET)
	public void upvoteReply(Model model, @PathVariable("id") Long id, @PathVariable("username") String username) {
		User user = userService.findByUsername(username);
		Reply reply = replyService.findById(id);
		Vote vote = new Vote(user, reply, 1);
		voteService.save(vote);
	}

	/**
	 * Request method GET with requestmapping value =
	 * /reply/upvote/{id}/{username}/remove
	 * 
	 * @param model    entity used in jsp page
	 * @param id       reply id
	 * @param username user username
	 * @return
	 */
	@RequestMapping(value = { "reply/upvote/{id}/{username}/remove" }, method = RequestMethod.GET)
	public void removeUpvote(Model model, @PathVariable("id") Long id, @PathVariable("username") String username) {
		Vote toBeDeleted = voteService.findByReplyIdAndUserId(id, userService.findByUsername(username).getId());
		voteService.deleteById(toBeDeleted.getId());
	}

	/**
	 * Request method GET with requestmapping value =
	 * /reply/downvote/{id}/{username}
	 * 
	 * @param model    entity used in jsp page
	 * @param id       reply id
	 * @param username user username
	 * @return
	 */
	@RequestMapping(value = { "reply/downvote/{id}/{username}" }, method = RequestMethod.GET)
	public void downvoteReply(Model model, @PathVariable("id") Long id, @PathVariable("username") String username) {
		User user = userService.findByUsername(username);
		Reply reply = replyService.findById(id);
		Vote vote = new Vote(user, reply, -1);
		voteService.save(vote);
	}

	/**
	 * Request method GET with requestmapping value =
	 * /reply/downvote/{id}/{username}/remove
	 * 
	 * @param model    entity used in jsp page
	 * @param id       reply id
	 * @param username user username
	 * @return
	 */
	@RequestMapping(value = { "reply/downvote/{id}/{username}/remove" }, method = RequestMethod.GET)
	public void removeDownvote(Model model, @PathVariable("id") Long id, @PathVariable("username") String username) {
		Vote toBeDeleted = voteService.findByReplyIdAndUserId(id, userService.findByUsername(username).getId());
		voteService.deleteById(toBeDeleted.getId());
	}
}
