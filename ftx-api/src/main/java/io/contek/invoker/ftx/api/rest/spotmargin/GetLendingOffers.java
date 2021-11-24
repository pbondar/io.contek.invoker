package io.contek.invoker.ftx.api.rest.spotmargin;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.ftx.api.rest.common.RestResponse;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

import static io.contek.invoker.ftx.api.ApiFactory.RateLimits.ONE_REST_REQUEST;

@NotThreadSafe
public final class GetLendingOffers extends SpotMarginRestRequest<GetLendingOffers.Response> {

    GetLendingOffers(final IActor actor, final RestContext context) {
        super(actor, context);
    }

    @Override
    protected ImmutableList<TypedPermitRequest> getRequiredQuotas() {
        return ONE_REST_REQUEST;
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    @Override
    protected RestMethod getMethod() {
        return RestMethod.GET;
    }

    @Override
    protected String getEndpointPath() {
        return "/api/spot_margin/offers";
    }

    @Override
    protected RestParams getParams() {
        return RestParams.empty();
    }

    @NotThreadSafe
    public static final class Response extends RestResponse<List<LendingOffer>> {}
}
