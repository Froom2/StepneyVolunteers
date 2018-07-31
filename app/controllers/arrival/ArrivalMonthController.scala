package controllers.arrival

import javax.inject.Inject

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

class ArrivalMonthController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def arrivalMonth() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.arrival.arrival_month())
  }
}
