import { useEffect, useState } from "react";

import MainLayout from "../layouts/MainLayout";

import { getProfile } from "../services/profileService";
import { refreshProfile } from "../services/refreshService";

import type { Profile } from "../types/Profile";

import ProfileCard from "../components/ProfileCard";
import SummaryCards from "../components/SummaryCards";
import PlatformCard from "../components/PlatformCard";

import PlatformComparisonChart
  from "../components/PlatformComparisonChart";

import ScoreContributionChart
  from "../components/ScoreContributionChart";

import GitHubActivity
  from "../components/GitHubActivity";

export default function Dashboard() {

  const [profile, setProfile] =
    useState<Profile | null>(null);

  const [loading, setLoading] =
    useState(false);

  const fetchProfile = async () => {

    try {

      const data =
        await getProfile(1);

      setProfile(data);

    } catch (error) {

      console.error(error);
    }
  };

  const handleRefresh = async () => {

    try {

      setLoading(true);

      await refreshProfile(1);

      await fetchProfile();

    } catch (error) {

      console.error(error);

    } finally {

      setLoading(false);
    }
  };

  useEffect(() => {

    fetchProfile();

  }, []);

  if (!profile) {

    return (
      <MainLayout>
        Loading...
      </MainLayout>
    );
  }

  return (
    <MainLayout>

      <div className="grid lg:grid-cols-4 gap-6">

        <div>

          <ProfileCard
            profile={profile}
            onRefresh={handleRefresh}
          />

          {loading && (

            <p className="text-center mt-3 text-blue-600">
              Refreshing...
            </p>

          )}

        </div>

        <div className="lg:col-span-3">

          <SummaryCards
            profile={profile}
          />

          <div className="grid md:grid-cols-3 gap-4 mt-6">

            {profile.platforms.map(
              (platform) => (

                <PlatformCard
                  key={platform.platform}
                  platform={platform}
                />

              )
            )}

          </div>

          <div className="grid lg:grid-cols-2 gap-6 mt-6">

            <PlatformComparisonChart
              profile={profile}
            />

            <ScoreContributionChart
              profile={profile}
            />

          </div>

          <div className="mt-6">

            <GitHubActivity
              username="HemaNagaChand-Boppana"
            />

          </div>

        </div>

      </div>

    </MainLayout>
  );
}