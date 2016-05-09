package org.eclipse.viatra.gui.tests.queries;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import org.eclipse.viatra.addon.validation.core.api.Severity;
import org.eclipse.viatra.addon.validation.core.api.IConstraintSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import org.eclipse.viatra.gui.tests.queries.util.NotAllocatedButRunningQuerySpecification;

public class NotAllocatedButRunningConstraint0 implements IConstraintSpecification {

    private NotAllocatedButRunningQuerySpecification querySpecification;

    public NotAllocatedButRunningConstraint0() throws ViatraQueryException {
        querySpecification = NotAllocatedButRunningQuerySpecification.instance();
    }

    @Override
    public String getMessageFormat() {
        return "$app.identifier$ is not allocated but it is running";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = ImmutableMap.of(
            "app",signature.get("app")
        );
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = ImmutableList.of(
            "app"
        );
        return keyNames;
    }

    @Override
    public List<String> getPropertyNames() {
        List<String> propertyNames = ImmutableList.of(
        );
        return propertyNames;
    }

    @Override
    public Set<List<String>> getSymmetricPropertyNames() {
        Set<List<String>> symmetricPropertyNamesSet = ImmutableSet.<List<String>>of(
        );
        return symmetricPropertyNamesSet;
    }

    @Override
    public Set<List<String>> getSymmetricKeyNames() {
        Set<List<String>> symmetricKeyNamesSet = ImmutableSet.<List<String>>of(
        );
        return symmetricKeyNamesSet;
    }

    @Override
    public Severity getSeverity() {
        return Severity.ERROR;
    }

    @Override
    public IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>> getQuerySpecification() {
        return querySpecification;
    }

}
