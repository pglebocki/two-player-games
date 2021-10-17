package org.home.twoplayergames.ox.dagger

import dagger.Module
import dagger.Provides
import org.home.twoplayergames.engine.minmax.MinMax
import org.home.twoplayergames.engine.minmax.PositionEvaluator
import org.home.twoplayergames.ox.game.OXPosition
import org.home.twoplayergames.ox.game.OXPositionEvaluator

@Module
class AppModule {

    @Provides
    fun providesPositionEvaluator(): PositionEvaluator<OXPosition> = OXPositionEvaluator()

    @Provides
    fun providesMinMax(
        evaluator: PositionEvaluator<OXPosition>
    ): MinMax<OXPosition> = MinMax(evaluator)
}